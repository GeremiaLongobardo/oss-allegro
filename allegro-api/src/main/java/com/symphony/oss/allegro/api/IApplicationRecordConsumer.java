/*
 *
 *
 * Copyright 2021 Symphony Communication Services, LLC.
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

package com.symphony.oss.allegro.api;

import com.symphony.oss.models.object.canon.facade.IApplicationObjectHeader;
import com.symphony.oss.models.object.canon.facade.IApplicationObjectPayload;
import com.symphony.oss.models.object.canon.facade.IStoredApplicationRecord;

/**
 * Consumer for decrypted StoredApplicationRecords.
 * 
 * @author Bruce Skingle
 *
 * @param <H> The type of the unencrypted header.
 * @param <P> The type of the decrypted payload.
 */
@FunctionalInterface
public interface IApplicationRecordConsumer<H extends IApplicationObjectHeader, P extends IApplicationObjectPayload>
{
    /**
     * Consume the given decrypted record.
     *
     * @param record the record as stored (with encrypted payload). 
     * @param header the unencrypted header.
     * @param payload the decrypted payload.
     */
    void accept(IStoredApplicationRecord record, H header, P payload);
}