const express = require('express');
const app = express();
const fcmRoutes = require('./routes/fcm');
app.use('/fcm', fcmRoutes.router);

const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/depremdb', { useNewUrlParser: true, useUnifiedTopology: true });