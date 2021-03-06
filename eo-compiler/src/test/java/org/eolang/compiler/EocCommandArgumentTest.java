/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 eolang.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.eolang.compiler;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link EocCommandArgument}.
 *
 * @author John Page (johnpagedev@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public final class EocCommandArgumentTest {

    /**
     * An EocCommandArgument does not exist when there is
     * no second input argument.
     *
     * @throws Exception If there's an exception.
     */
    @Test
    public void doesNotExistWhenThereIsNoSecondInputArgument()
        throws Exception {
        MatcherAssert.assertThat(
            new EocCommandArgument(new String[]{"first"}).isEmpty(),
            Matchers.is(true)
        );
    }

    /**
     * An EocCommandArgument does exist when there is a second input argument.
     *
     * @throws Exception If there's an exception.
     */
    @Test
    public void doesExistWhenThereIsASecondInputArgument() throws Exception {
        MatcherAssert.assertThat(
            new EocCommandArgument(
                new String[]{"first", "second", "third"}
            ).isEmpty(),
            Matchers.is(false)
        );
    }

    /**
     * An EocCommandArgument matches the value of the second input argument.
     *
     * @throws Exception If there's an exception.
     */
    @Test
    public void matchesTheValueOfTheSecondInputArgument() throws Exception {
        final String second = "second";
        MatcherAssert.assertThat(
            new EocCommandArgument(
                new String[]{"first", second, "third"}
            ).string(),
            Matchers.is(second)
        );
    }

    /**
     * An EocCommandArgument is an empty string when there are no input
     * arguments at all.
     *
     * @throws Exception If there's an exception.
     */
    @Test
    public void isAnEmptyStringWhenThereAreNoInputArgumentsAtAll()
        throws Exception {
        MatcherAssert.assertThat(
            new EocCommandArgument(new String[]{}).string(),
            Matchers.is("")
        );
    }

    /**
     * An EocCommandArgument is an empty string when there is no second
     * input argument.
     *
     * @throws Exception If there's an exception.
     */
    @Test
    public void isAnEmptyStringWhenThereIsNoSecondInputArgument()
        throws Exception {
        MatcherAssert.assertThat(
            new EocCommandArgument(new String[]{"first"}).string(),
            Matchers.is("")
        );
    }
}
