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
package ru.olegcherednik.utils.gson.data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Oleg Cherednik
 * @since 08.01.2021
 */
@SuppressWarnings("AssignmentOrReturnOfFieldWithMutableType")
public final class Book {

    private String title;
    private ZonedDateTime date;
    private int year;
    private List<String> authors;

    public Book() {
    }

    public Book(String title, ZonedDateTime date, int year, List<String> authors) {
        this.title = title;
        this.date = date;
        this.year = year;
        this.authors = authors;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Book))
            return false;

        Book book = (Book)obj;
        return year == book.year && title.equals(book.title) && date.equals(book.date) && authors.equals(book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, year, authors);
    }

}
