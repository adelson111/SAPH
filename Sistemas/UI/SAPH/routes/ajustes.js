var express = require('express');
var router = express.Router();
var Client = require('node-rest-client').Client;
var client = new Client();

router.get('/perfil',(req, res, next)=>{ 
        res.render('perfil', {
        title: 'Configurações - SAPH',
    });
}); 
 
      
module.exports = router;
