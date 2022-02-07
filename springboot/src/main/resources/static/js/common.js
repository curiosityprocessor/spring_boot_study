const sendHttpRequestByKey = (method, url, key, value) => {
    let dto = {}
    dto[key] = value;
    sendHttpRequest(method, url, dto);
}

const sendHttpRequest = (method, url, dto) => {
    let newForm = document.createElement("form");
    newForm.setAttribute("method", method);
    newForm.setAttribute("action", url);
    newForm.setAttribute("data", dto);
    document.body.appendChild(newForm);
    newForm.submit();
}