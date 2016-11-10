#!/bin/bash
cd /birds
setsid jackd -d dummy -r 44100 &
sleep 3
setsid /usr/bin/xvfb-run --server-args="-screen 0, 1280x800x24" sclang grains.sc &
cd output
jack_capture -f ogg


