/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package ru.olegcherednik.json.gson.datetime;

import com.google.gson.GsonBuilder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import ru.olegcherednik.json.gson.factories.AutoCloseableIteratorTypeAdapterFactory;
import ru.olegcherednik.json.gson.factories.EnumIdTypeAdapterFactory;
import ru.olegcherednik.json.gson.datetime.adapter.DateTypeAdapter;
import ru.olegcherednik.json.gson.datetime.adapter.InstantTypeAdapter;
import ru.olegcherednik.json.gson.datetime.adapter.LocalDateTimeTypeAdapter;
import ru.olegcherednik.json.gson.datetime.adapter.LocalDateTypeAdapter;
import ru.olegcherednik.json.gson.datetime.adapter.LocalTimeTypeAdapter;
import ru.olegcherednik.json.gson.datetime.adapter.OffsetDateTimeTypeAdapter;
import ru.olegcherednik.json.gson.datetime.adapter.OffsetTimeTypeAdapter;
import ru.olegcherednik.json.gson.datetime.adapter.ZonedDateTimeTypeAdapter;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Consumer;

/**
 * @author Oleg Cherednik
 * @since 03.01.2024
 */
@Builder
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings("all")
public class JavaTimeModule implements Consumer<GsonBuilder> {

    protected final DateTimeFormatter instant;
    protected final DateTimeFormatter localDate;
    protected final DateTimeFormatter localTime;
    protected final DateTimeFormatter localDateTime;
    protected final DateTimeFormatter offsetTime;
    protected final DateTimeFormatter offsetDateTime;
    protected final DateTimeFormatter zonedDateTime;
    protected final DateFormat date;

    @Override
    public void accept(GsonBuilder builder) {
        registerTypeAdapterFactories(builder);
        registerTypeAdapters(builder);
    }

    protected void registerTypeAdapterFactories(GsonBuilder builder) {
        builder.registerTypeAdapterFactory(AutoCloseableIteratorTypeAdapterFactory.INSTANCE)
               .registerTypeAdapterFactory(EnumIdTypeAdapterFactory.INSTANCE);
    }

    protected void registerTypeAdapters(GsonBuilder builder) {
        builder.registerTypeAdapter(Instant.class, new InstantTypeAdapter(instant).nullSafe())
               .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter(localDate).nullSafe())
               .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter(localTime).nullSafe())
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter(localDateTime).nullSafe())
               .registerTypeAdapter(OffsetTime.class, new OffsetTimeTypeAdapter(offsetTime).nullSafe())
               .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter(offsetDateTime).nullSafe())
               .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeTypeAdapter(zonedDateTime).nullSafe())
               .registerTypeAdapter(Date.class, new DateTypeAdapter(date).nullSafe());
    }

}
