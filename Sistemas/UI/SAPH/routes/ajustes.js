var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/',(req, res, next)=>{
        res.render('dados', {
        title: 'Configurações - SAPH',
    });
});

router.get('/dados',(req, res, next)=>{
        res.render('dados', {
        title: 'Configurações - SAPH',
    });
});

module.exports = router;
