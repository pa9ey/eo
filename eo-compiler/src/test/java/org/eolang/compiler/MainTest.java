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

import java.io.PrintStream;
import java.util.Arrays;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link Main}.
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public final class MainTest {

    /**
     * Main can print a simple text.
     * @throws Exception If some problem inside
     */
    @Test
    public void printsHelpInstructions() throws Exception {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            new Main(new PrintStream(baos), "--help").exec();
            MatcherAssert.assertThat(
                new String(baos.toByteArray()),
                Matchers.containsString(
                    "Use --demo to list compilation examples."
                )
            );
        }
    }

    /**
     * Main prints instructions in response to the demo command.
     *
     * @throws Exception If some problem inside
     */
    @Test
    public void printsInstructionsInResponseToTheDemoCommand()
        throws Exception {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            new Main(new PrintStream(baos), "--demo").exec();
            MatcherAssert.assertThat(
                new String(baos.toByteArray()),
                Matchers.containsString("Use --demo <filename>")
            );
        }
    }

    /**
     * Main prints filenames in response to the demo command.
     *
     * @throws Exception If some problem inside
     */
    @Test
    public void printsFilenamesInResponseToTheDemoCommand() throws Exception {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            new Main(new PrintStream(baos), "--demo").exec();
            MatcherAssert.assertThat(
                new String(baos.toByteArray()),
                Matchers.stringContainsInOrder(
                    Arrays.asList("book.eo", "zero.eo")
                )
            );
        }
    }

    /**
     * Main prints the EO file in response to the demo command with a filename.
     *
     * @throws Exception If some problem inside
     */
    @Test
    public void printsEoFileInResponseToDemoCommandWithAFilename()
        throws Exception {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            new Main(new PrintStream(baos), "--demo", "book.eo").exec();
            MatcherAssert.assertThat(
                new String(baos.toByteArray()),
                Matchers.stringContainsInOrder(
                    Arrays.asList("\nEOLANG:\n", "type Book:")
                )
            );
        }
    }

    /**
     * Main prints the compiled file in response to the demo command
     * with a filename.
     *
     * @throws Exception If some problem inside
     */
    @Test
    public void printsCompiledFileInResponseToTheDemoCommmand()
        throws Exception {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            new Main(new PrintStream(baos), "--demo", "pixel.eo").exec();
            MatcherAssert.assertThat(
                new String(baos.toByteArray()),
                Matchers.stringContainsInOrder(
                    Arrays.asList("\n\nJAVA:\n", "Pixel moveTo")
                )
            );
        }
    }
}
