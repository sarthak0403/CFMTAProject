#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Apr 10 14:21:42 2017

@author: Sarthak
"""
# Simple python Flask app

from flask import Flask
import os
import logging
import sys

app = Flask(__name__)

# Get port from environment variable or choose 5005 as local default
port = int(os.getenv("PORT", 5005))

# Basic DEBUG logging to stdout
logging.basicConfig(level=logging.DEBUG, stream=sys.stdout)

"""
service endpoint definition and implementation
"""
@app.route('/')
def hello_world():
    logging.debug('Received request for hello_world()')
    return '<html><body> <h1>Hello World!</h1> <p>This is python module.</p> </body></html>'

if __name__ == '__main__':
    # Run the app, listening on all IPs with our chosen port number
    app.run(host='0.0.0.0', port=port)