const express = require('express');
const app = express();
const fcmRoutes = require('./routes/fcm');
app.use(fcmRoutes.router);