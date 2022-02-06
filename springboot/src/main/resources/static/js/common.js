const sendHttpPostByKey = (url, key, value) => {
    let dto = {}
    dto[key] = value;
    sendHttpPost(url, dto);
}

const sendHttpPost = (url, dto) => {
    let newForm = document.createElement("form");
    newForm.setAttribute("method", "post");
    newForm.setAttribute("action", url);
    newForm.setAttribute("data", dto);
    document.body.appendChild(newForm);
    newForm.submit();
}