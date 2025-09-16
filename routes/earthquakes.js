const express = require('express');
const router = express.Router();
const Earthquake = require('../models/Earthquake');

// Get recent earthquakes
// Optional query params: limit, minMagnitude, since (ISO string)
router.get('/', async (req, res) => {
  try {
    const limit = parseInt(req.query.limit) || 50;
    const minMagnitude = parseFloat(req.query.minMagnitude) || 0;
    const since = req.query.since ? new Date(req.query.since) : null;

    const results = await Earthquake.recent(limit, minMagnitude, since);
    res.json({ success: true, earthquakes: results, total: results.length });
  } catch (error) {
    console.error('❌ Earthquakes list error:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

// Get single earthquake by id
router.get('/:id', async (req, res) => {
  try {
    const id = req.params.id;
    const eq = await Earthquake.findById(id).lean();
    if (!eq) return res.status(404).json({ error: 'Deprem bulunamadı' });
    res.json({ success: true, earthquake: eq });
  } catch (error) {
    console.error('❌ Earthquake fetch error:', error);
    res.status(500).json({ error: 'Sunucu hatası' });
  }
});

module.exports = router;
