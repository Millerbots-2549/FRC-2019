import json
import time
import sys
from threading import Thread

from cscore import CameraServer, VideoSource
from networktables import NetworkTablesInstance
import cv2
import numpy as np
from networktables import NetworkTables
import math

cam = cv2