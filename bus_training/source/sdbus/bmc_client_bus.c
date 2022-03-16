#include <stdio.h>
#include <stdlib.h>
#include <systemd/sd-bus.h>

int main(int argc, char *argv[]) {
        sd_bus_error error = SD_BUS_ERROR_NULL;
        sd_bus_message *m = NULL;
        sd_bus *bus = NULL;
        float result;
	const char *s;
        int r;


        /* Connect to the user bus */
        r = sd_bus_open_user(&bus);
        if (r < 0) {
                fprintf(stderr, "Failed to connect to system bus: %s\n", strerror(-r));
                goto finish;
        }

        /* Issue the get-property and store the obtained response from message in m */
		       
	r = sd_bus_get_property(bus, "xyz.openbmc_project.HealthMon", "/xyz/openbmc_project/sensors/utilization/CPU", "xyz.openbmc_project.Sensor.Value", "Value", &error, &m, "d");

        if (r < 0) {
                fprintf(stderr, "Failed to issue get-property call: %s\n", error.message);
                goto finish;
        }

        /* Parse the response message */
        r = sd_bus_message_read(m, "d", &result);
        if (r < 0) {
                fprintf(stderr, "Failed to parse response message: %s\n", strerror(-r));
                goto finish;
        }

        printf("CPU Utilization is  %f.\n", result);

finish:
        sd_bus_error_free(&error);
        sd_bus_message_unref(m);
        sd_bus_unref(bus);

        return r < 0 ? EXIT_FAILURE : EXIT_SUCCESS;
}
