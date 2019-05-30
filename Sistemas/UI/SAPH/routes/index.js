var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'SAPH' });
});

router.get('/contato',(req, res, next)=>{
  res.render('contato', {
    title: 'Contato - SAPH',
  });
});

router.get('/sobre',(req, res, next)=>{
  res.render('sobre', {
    title: 'Sobre - SAPH',
  });
});

router.get('/login',(req, res, next)=>{
  res.render('login', {
    title: 'Login - SAPH',
  });
});

router.get('/inicio',(req, res, next)=>{
  res.render('inicio', {
    title: 'Home - SAPH',
  });
});
router.get('/solicitacoes',(req, res, next)=>{
  solicitacoes = [
    {
      'tipo':'tipo1',
      'itens':[
        {
          'nome':'s1item1',
          'campos':[
            {
              'nome':'campo1',
              'tipo':'text',
            },
            {
              'nome':'campo2',
              'tipo':'text',
            }
          ]
        },
        {
          'nome':'s1item2',
          'campos':[
            {
              'nome':'campo1',
              'tipo':'text',
            },
            {
              'nome':'campo2',
              'tipo':'file',
            },{
              'nome':'campo3',
              'tipo':'number',
            }
          ]
        },
      ],
    },
    {
      'tipo':'tipo2',
      'itens':[
        {
          'nome':'s2item1',
          'campos':[
            {
              'nome':'campo1',
              'tipo':'text',
            },
            {
              'nome':'campo3',
              'tipo':'number',
            }
          ]
        },
        {
          'nome':'s2item2',
          'campos':[
            {
              'nome':'campo3',
              'tipo':'number',
            }
          ]
        },
        {
          'nome':'s2item3',
          'campos':[
            {
              'nome':'campo1',
              'tipo':'text',
            },
            {
              'nome':'campo2',
              'tipo':'file',
            },
            {
              'nome':'campo3',
              'tipo':'number',
            },
            {
              'nome':'campo4',
              'tipo':'number',
            }
          ]
        },
      ],
    },
    {
      'tipo':'tipo3',
      'itens':[
        {
          'nome':'s3item1',
          'campos':[
            {
              'nome':'campo3',
              'tipo':'number',
            },
          ],
        },
      ],
    },
  ];
  res.render('solicitacoes', {
    title: 'Solicitacoes - SAPH',
    tipos: solicitacoes,
  });
});
router.get('/delegacao',(req, res, next)=>{
  res.render('delegacao', {
    title: 'Delegações - SAPH',
  });
});
router.get('/visualizar',(req, res, next)=>{
  res.render('visualizar', {
    title: 'Visualizar - SAPH',
  });
});

router.get('/exportar',(req, res, next)=>{
  res.render('exportar', {
    title: 'Exportar - SAPH',
  });
});
module.exports = router;
