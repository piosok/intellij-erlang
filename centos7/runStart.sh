#!/bin/bash
#Script to be used as entry point for Docker	cd "$(dirname "$0")"
export OTPROOT=/usr/lib/erlang
export ERL_INTERFACE_DIR=$(find /usr/lib/erlang/lib/ -type d -name erl_interface-*)/
export OTP_ERTS_DIR=/usr/lib/erlang/erts-9.2/

echo "Please continue by running either:"
ls -1 ~/*.sh | grep -v "runStart"

cd ~
bash
