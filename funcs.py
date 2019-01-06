#!/usr/sbin/python

from math import exp

# domain function
domain = lambda m, n, sig: exp( -((m**2 + n**2) / (2*sig*sig)) )

# range function
range = lambda a, b, sig: exp( -((a-b)**2 / (2*sig*sig)) )
