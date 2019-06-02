var express = require('express');
var router = express.Router();

router.get('/new',(req, res, next)=>{
  solicitacoes = [
    {
      'tipo':'Uma solicitação qualquer',
      'itens':[
        {
          'nome':'Item qualquer',
          'campos':[
            {
              'nome':'Proin',
              'tipo':'text',
            },
            {
              'nome':'Nunc',
              'tipo':'text',
            }
          ]
        },
        {
          'nome':'Outro item',
          'campos':[
            {
              'nome':'Integer',
              'tipo':'text',
            },
            {
              'nome':'Consectetur',
              'tipo':'file',
            },
            {
              'nome':'Quisque',
              'tipo':'number',
            },
            {
              'nome':'Tincidunt',
              'tipo':'text',
            },
            {
              'nome':'Egestas',
              'tipo':'file',
            },
            {
              'nome':'Tortor',
              'tipo':'number',
            },
            {
              'nome':'Scelerisque',
              'tipo':'text',
            },
            {
              'nome':'Imperdiet',
              'tipo':'file',
            },
            {
              'nome':'Laoreet',
              'tipo':'number',
            },
          ]
        },
      ],
    },
    {
      'tipo':'Duis fermentum',
      'itens':[
        {
          'nome':'Nunc in',
          'campos':[
            {
              'nome':'Pretium',
              'tipo':'text',
            },
            {
              'nome':'Metus',
              'tipo':'number',
            }
          ]
        },
        {
          'nome':'Aliquam dapibus',
          'campos':[
            {
              'nome':'Ipsum',
              'tipo':'number',
            }
          ]
        },
        {
          'nome':'Aenean augue',
          'campos':[
            {
              'nome':'Sollicitudin',
              'tipo':'text',
            },
            {
              'nome':'Cursus',
              'tipo':'file',
            },
            {
              'nome':'Purus',
              'tipo':'number',
            },
            {
              'nome':'Placerat',
              'tipo':'number',
            }
          ]
        },
      ],
    },
    {
      'tipo':'Fusce iaculis',
      'itens':[
        {
          'nome':'Pellentesque habitant',
          'campos':[
            {
              'nome':'Pulvinar',
              'tipo':'number',
            },
          ],
        },
      ],
    },
  ];
  res.render('new', {
    title: 'Solicitacoes - SAPH',
    tipos: solicitacoes,
  });
});
module.exports = router;
