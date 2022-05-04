package com.github.curiousoddman.rgxgen.iterators;

/* **************************************************************************
   Copyright 2019 Vladislavs Varslavans

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
/* **************************************************************************/

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class IncrementalLengthIterator implements StringIterator {
    private final Supplier<StringIterator> aSupplier;
    private final int                      aMin;
    private final int                      aMax;

    private int              aCurrentLength;
    private StringIterator[] aCurrentIterators;
    private boolean          aInit = true;


    // (a|b){1} -> "a", "b" --> "a", "b"
    // (a|b){2} -> "a", "b" --> "aa", "ab", "ba", "bb"
    // (a|b){1,2} -> "a", "b" --> "a", "b", "aa", "ab", "ba", "bb"
    // (a|b){0,2} -> "a", "b" --> "", "a", "b", "aa", "ab", "ba", "bb"


    // Take 0 from list
    // Take 1 from list
    // Take and concatenate 2 from list
    // ...

    public IncrementalLengthIterator(Supplier<StringIterator> supplier, int min, int max) {
        aSupplier = supplier;
        aMin = min;
        aCurrentLength = min;
        aMax = max;
        reset();
    }

    private boolean lengthCanGrow() {
        return aCurrentLength < aMax || aCurrentIterators.length < aCurrentLength || aMax < 0;
    }

    private boolean hasMoreForCurrentLength() {
        return Arrays.stream(aCurrentIterators)
                     .anyMatch(Iterator::hasNext);
    }

    @Override
    public boolean hasNext() {
        return lengthCanGrow() || hasMoreForCurrentLength();
    }

    private void extendIterators() {
        StringIterator[] tmp = new StringIterator[aCurrentLength];
        for (int i = 0; i < aCurrentIterators.length; i++) {
            tmp[i] = aCurrentIterators[i];
            tmp[i].reset();
        }
        tmp[aCurrentLength - 1] = aSupplier.get();
        aCurrentIterators = tmp;
        aInit = false;
        for (int i = 0; i < aCurrentLength; i++) {
            aCurrentIterators[i].next();
        }
    }

    @Override
    public String next() {
        if (aCurrentLength == 0) {
            ++aCurrentLength;
            return "";
        } else if (aInit) {
            extendIterators();
            return current();
        } else {
            // Advance one of iterators
            for (int i = aCurrentLength - 1; i >= 0; --i) {
                if (aCurrentIterators[i].hasNext()) {
                    aCurrentIterators[i].next();
                    break;
                } else if (i == 0) {
                    if (aCurrentLength < aMax || aMax < 0) {
                        ++aCurrentLength;
                        extendIterators();
                    } else {
                        // We can only increase length up to max
                        throw new NoSuchElementException("No more unique values");
                    }
                } else {
                    aCurrentIterators[i].reset();
                    aCurrentIterators[i].next();
                }
            }
        }

        return current();
    }

    @Override
    public final void reset() {
        aCurrentLength = aMin;
        aInit = true;
        aCurrentIterators = new StringIterator[aCurrentLength];
        for (int i = 0; i < aCurrentLength; i++) {
            aCurrentIterators[i] = aSupplier.get();
        }
    }

    @Override
    public String current() {
        return Arrays.stream(aCurrentIterators)
                     .map(StringIterator::current)
                     .reduce("", String::concat);
    }
}
