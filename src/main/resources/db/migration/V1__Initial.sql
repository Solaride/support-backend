CREATE TYPE "event_type" AS ENUM (
    'driver_change',
    'recharge',
    'repairs',
    'checkpoint'
    );

CREATE TABLE IF NOT EXISTS "route"
(
    "id"             SERIAL PRIMARY KEY,
    "name"           varchar,
    "roads"          Json,
    "roads_original" Json,
    "updated_at"     timestamp,
    "synced_at"      timestamp
);

CREATE TABLE IF NOT EXISTS "penalty"
(
    "id"        SERIAL PRIMARY KEY,
    "drive_id"  int,
    "seconds"   int,
    "synced_at" timestamp
);

CREATE TABLE IF NOT EXISTS "drive"
(
    "id"         SERIAL PRIMARY KEY,
    "route_id"   int,
    "name"       varchar,
    "start"      timestamp,
    "end"        timestamp,
    "created_at" timestamp,
    "updated_at" timestamp,
    "synced_at"  timestamp
);

CREATE TABLE IF NOT EXISTS "driver"
(
    "id"         SERIAL PRIMARY KEY,
    "drive_id"   int,
    "name"       varchar,
    "weight"     int,
    "created_at" timestamp,
    "updated_at" timestamp,
    "synced_at"  timestamp
);

CREATE TABLE IF NOT EXISTS "weather"
(
    "id"              SERIAL PRIMARY KEY,
    "time"            timestamp,
    "wind_speed"      float4,
    "wind_direction"  float4,
    "solar_intensity" float4,
    "air_temperature" float4,
    "air_pressure"    float4,
    "air_humidity"    float4
);

CREATE TABLE IF NOT EXISTS "telemetry"
(
    "id"                  SERIAL PRIMARY KEY,
    "time"                timestamp,
    "battery_temp"        float4,
    "battery_voltage"     float4,
    "bms_temp"            float4,
    "left_motor_rpm"      int,
    "left_motor_current"  float4,
    "left_motor_temp"     float4,
    "right_motor_rpm"     int,
    "right_motor_current" float4,
    "right_motor_temp"    float4,
    "solar_charging"      float4,
    "cabin_temp"          float4
);

CREATE TABLE IF NOT EXISTS "event"
(
    "id"          SERIAL PRIMARY KEY,
    "drive_id"    int,
    "description" varchar,
    "type"        event_type,
    "lat"         varchar,
    "lon"         varchar,
    "created_at"  timestamp,
    "synced_at"   timestamp
);

ALTER TABLE "penalty"
    ADD FOREIGN KEY ("drive_id") REFERENCES "drive" ("id");

ALTER TABLE "drive"
    ADD FOREIGN KEY ("route_id") REFERENCES "route" ("id");

ALTER TABLE "driver"
    ADD FOREIGN KEY ("drive_id") REFERENCES "drive" ("id");

ALTER TABLE "event"
    ADD FOREIGN KEY ("drive_id") REFERENCES "drive" ("id");