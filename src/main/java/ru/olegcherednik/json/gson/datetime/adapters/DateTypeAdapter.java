/*
 * Copyright Oleg Cherednik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.olegcherednik.json.gson.datetime.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Oleg Cherednik
 * @since 09.10.2021
 */
@RequiredArgsConstructor
public class DateTypeAdapter extends TypeAdapter<Date> {

    protected final DateFormat df;

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        out.value(df.format(value));
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        try {
            return df.parse(in.nextString());
        } catch (ParseException e) {
            throw new IOException(e);
        }
    }

}
