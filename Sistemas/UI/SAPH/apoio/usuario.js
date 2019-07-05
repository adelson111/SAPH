var Client = require('node-rest-client').Client;
var client = new Client();
module.exports ={
    render(req, res , err){
        res.render('login', {
            title: 'Login - SAPH',
            body: req.body
          });
    },

    login(email, senha){
        return new Promise((resolve, reject) =>{
          client.post(server_backend+"usuario/autenticar/"+email+"/"+senha,function (data, response) {
            if(data!=null){
              resolve(data);
            }else{
              reject(Error('testever:'));
            }
          });
        });
    }

};
