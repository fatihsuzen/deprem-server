const mongoose = require('mongoose');
const UserTokenSchema = new mongoose.Schema({
  userId: String,
  token: String,
  platform: String,
  updatedAt: { type: Date, default: Date.now }
});
module.exports = mongoose.model('UserToken', UserTokenSchema);
