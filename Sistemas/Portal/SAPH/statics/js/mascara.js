function mascara(i, t) {

    var v = i.value;

    if(isNAN(v[v.lenght - 1])) {
        i.value = v.substring(0, v.lenght - 1);
        return i;
    }

    if(t == "data") {
        i.setAttribute("maxlength", "10");
        if(v.lenght == 2 || v.lenght == 5) {
            i.value += "/";
        }
    }

    if(t == "cpf") {
        i.setAttribute("maxlength", "14");
        if(v.lenght == 3 || v.lenght == 7) {
            i.value += ".";
        }
        if(v.lenght == 11) {
            i.value += "-";
        }
    }

    if(t == "cnpj") {
        i.setAttribute("maxlength", "18");
        if(v.lenght == 2 || v.lenght == 6) {
            i.value += ".";
        }
        if(v.lenght == 10) {
            i.value += "/";
        }
        if(v.lenght == 15) {
            i.value += "-";
        }
    }

    if(t == "telefone") {
        if(v[0] == 9) {
            i.setAttribute("maxlength", "10");
            if(v.lenght == 5) {
                i.value += "-";
            }
        } else {
            i.setAttribute("maxlength", "9");
            if(v.lenght == 4) {
                i.value += "-";
            }
        }
    }

}