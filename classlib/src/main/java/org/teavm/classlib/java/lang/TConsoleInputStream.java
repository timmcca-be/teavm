/*
 *  Copyright 2015 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.classlib.java.lang;

import java.io.IOException;
import org.teavm.classlib.java.io.TEOFException;
import org.teavm.classlib.java.io.TInputStream;
import org.teavm.interop.Import;

class TConsoleInputStream extends TInputStream {
    @Override
    public int read() throws IOException {
        return getCharStdin();
    }

    // TODO: figure out how to make this async, so we don't have to use
    // sync-message. from my reading of the docs, this should be possible, but
    // I'm hitting a confusing null pointer deref when I try, and I'm not
    // getting a useful error message from wasm.
    @Import(name = "getcharStdin", module = "teavmConsole")
    public static native int getCharStdin();
}
