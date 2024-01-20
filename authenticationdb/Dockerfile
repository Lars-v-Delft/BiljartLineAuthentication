# Use an official MariaDB base image
FROM mariadb:latest
# Expose the port on which MariaDB will run
EXPOSE 3306
# Copy the SQL dump file into the image
COPY dump-biljartline_identity-202401191348.sql /docker-entrypoint-initdb.d/

