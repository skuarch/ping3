#!/bin/bash
ping -c 2 $1 > /dev/null && echo "true" || echo "false"