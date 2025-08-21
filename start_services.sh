#!/usr/bin/env bash

sm2 --start NINO_INSIGHTS_PROXY NINO_INSIGHTS NINO_GATEWAY INTERNAL_AUTH --appendArgs '{
        "NINO_INSIGHTS_PROXY": [
            "-J-Dauditing.consumer.baseUri.port=6001",
            "-J-Dauditing.consumer.baseUri.host=localhost",
            "-J-Dmicroservice.services.access-control.enabled=true",
            "-J-Dmicroservice.services.access-control.allow-list.0=nino-gateway",
            "-J-Dmicroservice.services.access-control.allow-list.1=allowed-test-hmrc-service"
        ],
        "NINO_INSIGHTS": [
            "-J-Dmicroservice.nino-insights.database.dbName=postgres",
            "-J-Dmicroservice.nino-insights.database.use-canned-data=true",
            "-J-Dauditing.enabled=true"
        ]
    }'
