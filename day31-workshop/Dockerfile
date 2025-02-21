FROM node:23 AS builder

WORKDIR /src

# Install Angular CLI
RUN npm i -g @angular/cli

COPY src src
COPY public public
COPY *.json .

# Install dependencies, clean install
# Build the Angular application
# dist/day31-workshop/browser
RUN npm ci && ng build

FROM caddy:2-alpine

LABEL maintainer="chuk"

WORKDIR /www

# Copy compiled Angular from builder
COPY --from=builder /src/dist/day31-workshop/browser html
COPY Caddyfile .

ENV PORT=8080

EXPOSE ${PORT}

SHELL [ "/bin/sh", "-c" ]
ENTRYPOINT caddy run --config Caddyfile
