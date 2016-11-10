FROM ubuntu:16.04

MAINTAINER Abram Hindle abram.hindle@softwareprocess.es

RUN apt-get update && apt-get install -y jack-capture \
    supercollider \
    jackd 

RUN apt-get install -y xvfb

ENV LANG "en_US.UTF-8"

RUN mkdir /birds
ADD grains.sc /birds
ADD run.sh /birds

