const mongoose = require('mongoose');

class DatabaseService {
  constructor() {
    this.isConnected = false;
  }

  async connect() {
    try {
      // MongoDB connection string - environment variable'dan gelecek
      const mongoURI = process.env.MONGODB_URI || 'mongodb://localhost:27017/deprem_app';
      
      await mongoose.connect(mongoURI, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
        maxPoolSize: 10,
        serverSelectionTimeoutMS: 5000,
        socketTimeoutMS: 45000,
      });

      this.isConnected = true;
      console.log('✅ MongoDB bağlantısı başarılı');
      
      // Connection event listeners
      mongoose.connection.on('error', (error) => {
        console.error('❌ MongoDB bağlantı hatası:', error);
        this.isConnected = false;
      });

      mongoose.connection.on('disconnected', () => {
        console.log('⚠️ MongoDB bağlantısı kesildi');
        this.isConnected = false;
      });

      mongoose.connection.on('reconnected', () => {
        console.log('✅ MongoDB yeniden bağlandı');
        this.isConnected = true;
      });

      return true;
    } catch (error) {
      console.error('❌ MongoDB bağlantı hatası:', error);
      this.isConnected = false;
      return false;
    }
  }

  async disconnect() {
    try {
      await mongoose.disconnect();
      this.isConnected = false;
      console.log('✅ MongoDB bağlantısı kapatıldı');
    } catch (error) {
      console.error('❌ MongoDB bağlantı kapatma hatası:', error);
    }
  }

  isHealthy() {
    return this.isConnected && mongoose.connection.readyState === 1;
  }

  getConnectionStatus() {
    const states = {
      0: 'disconnected',
      1: 'connected',
      2: 'connecting',
      3: 'disconnecting'
    };
    
    return {
      status: states[mongoose.connection.readyState] || 'unknown',
      isConnected: this.isConnected,
      dbName: mongoose.connection.name,
      host: mongoose.connection.host,
      port: mongoose.connection.port
    };
  }
}

module.exports = new DatabaseService();
