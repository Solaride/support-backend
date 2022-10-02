CREATE TABLE "weather" (
                           "id" SERIAL PRIMARY KEY,
                           "time" timestamp,
                           "wind_speed" float4,
                           "wind_direction" float4,
                           "solar_intensity" float4,
                           "air_temperature" float4,
                           "air_pressure" float4,
                           "air_humidity" float4
);

CREATE TABLE "telemetry" (
                             "id" SERIAL PRIMARY KEY,
                             "time" timestamp,
                             "battery_temp" float4,
                             "battery_voltage" float4,
                             "bms_temp" float4,
                             "left_motor_rpm" float4,
                             "left_motor_current" float4,
                             "left_motor_temp" float4,
                             "right_motor_rpm" float4,
                             "right_motor_current" float4,
                             "right_motor_temp" float4,
                             "solar_charging" float4,
                             "cabin_temp" float4
);
