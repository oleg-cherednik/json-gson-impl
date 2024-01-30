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

package ru.olegcherednik.json.gson.types;

import org.testng.annotations.Test;
import ru.olegcherednik.json.api.AutoCloseableIterator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Oleg Cherednik
 * @since 11.01.2021
 */
@Test
@SuppressWarnings("NewClassNamingConvention")
public class AutoCloseableIteratorParameterizedTypeTest {

    public void shouldRetrieveGivenClassesWhenCreateNewInstance() {
        AutoCloseableIteratorParameterizedType<String> type =
                new AutoCloseableIteratorParameterizedType<>(String.class);
        assertThat(type.getActualTypeArguments()).containsExactly(String.class);
        assertThat(type.getRawType()).isSameAs(AutoCloseableIterator.class);
        assertThat(type.getOwnerType()).isNull();
    }

}
