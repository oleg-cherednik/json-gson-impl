/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ru.olegcherednik.utils.gson;

import org.testng.annotations.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import static java.time.format.DateTimeFormatter.ISO_ZONED_DATE_TIME;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.olegcherednik.utils.gson.utils.PrettyPrintUtils.UNIX_LINE_SEPARATOR;
import static ru.olegcherednik.utils.gson.utils.PrettyPrintUtils.withUnixLineSeparator;

/**
 * @author Oleg Cherednik
 * @since 08.01.2021
 */
@Test
@SuppressWarnings("NewClassNamingConvention")
public class ZonedDateTimePrettyPrintGsonUtilsTest {

    public void shouldRetrievePrettyPrintJsonUTCZoneWhenWriteZonedDateTimeMapWithPrettyPrint() {
        Map<String, ZonedDateTime> map = ZonedDateTimeGsonUtilsTest.createData();
        String actual = GsonUtils.prettyPrint().writeValue(map);
        assertThat(withUnixLineSeparator(actual)).isEqualTo('{' + UNIX_LINE_SEPARATOR +
                "  \"UTC\": \"2017-07-23T13:57:14.225Z\"," + UNIX_LINE_SEPARATOR +
                "  \"Asia/Singapore\": \"2017-07-23T05:57:14.225Z\"," + UNIX_LINE_SEPARATOR +
                "  \"Australia/Sydney\": \"2017-07-23T03:57:14.225Z\"" + UNIX_LINE_SEPARATOR +
                '}');
    }

    public void shouldRetrievePrettyPrintJsonSingaporeZoneWhenWriteZonedDateTimeMapWithPrettyPrint() {
        GsonDecorator gsonUtils = GsonUtilsHelper.createPrettyPrintGsonDecorator(
                new GsonUtilsBuilder().zonedDateTimeFormatter(zone -> ZoneId.of("Asia/Singapore"), ISO_ZONED_DATE_TIME));

        Map<String, ZonedDateTime> map = ZonedDateTimeGsonUtilsTest.createData();
        String actual = gsonUtils.writeValue(map);
        assertThat(withUnixLineSeparator(actual)).isEqualTo('{' + UNIX_LINE_SEPARATOR +
                "  \"UTC\": \"2017-07-23T21:57:14.225+08:00[Asia/Singapore]\"," + UNIX_LINE_SEPARATOR +
                "  \"Asia/Singapore\": \"2017-07-23T13:57:14.225+08:00[Asia/Singapore]\"," + UNIX_LINE_SEPARATOR +
                "  \"Australia/Sydney\": \"2017-07-23T11:57:14.225+08:00[Asia/Singapore]\"" + UNIX_LINE_SEPARATOR +
                '}');
    }

}
