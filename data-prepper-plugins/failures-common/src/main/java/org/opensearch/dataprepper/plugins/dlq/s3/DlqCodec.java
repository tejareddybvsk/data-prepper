/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.dlq.s3;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DlqCodec {
    JSON("json"),
    NDJSON("ndjson");

    private final String option;

    DlqCodec(final String option) {
        this.option = option;
    }

    @JsonCreator
    public static DlqCodec fromOptionValue(final String option) {
        for (final DlqCodec codec : values()) {
            if (codec.option.equals(option)) {
                return codec;
            }
        }
        throw new IllegalArgumentException(
            "Unknown DLQ codec: " + option + ". Only json and ndjson are supported.");
    }

    public String getExtension() {
        return option;
    }
}
