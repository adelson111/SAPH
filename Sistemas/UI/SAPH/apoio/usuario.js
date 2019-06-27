var Client = require('node-rest-client').Client;
var client = new Client();
module.exports ={

    render(req, res , err){
        res.render('login', {
            title: 'Login - SAPH',
            bosy: req.body,
            err
          });
    },

    login(email, senha){
        return new Promise((resolve, reject) =>{
            client.query(
                `  client.post("http://localhost:8080/SAPH/saph/usuario/autenticar/"+email+"/"+senha`
                , [
                    email
                ], (err, results) =>{
                    if (err){
                        reject(err);
                    } else {

                        if(!results.length > 0){
                            reject('Usuário o senha incorretos')
                        }else{
                            let row = results[0];
                            
                            if (row.senha !== senha){
                                reject('Usuário o senha incorretos');
                            }else{
                                resolve(row);
                            }
                        }

                    }
                }
            )
        })
    }

};