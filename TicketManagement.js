'use strict'
const BASE_URL = "";

(function () {
    // create
    function displayOutput(element, { data }) {
        document.getElementById('createButton').addEventListener('click', function () {
            let data = {};
            document.querySelectorAll('#create > input').forEach(el => data[el.name] = el.value);
            axios.post(BASE_URL + '/people/createPeople', data)
                .then(res => displayOutput("createOutput", res)
                ).catch(err => console.error(err));

        });
        // read
        document.getElementById('readButton').addEventListener('click', function () {
            axios.get(BASE_URL + '/people/getAll')
                .then(res =>
                    document.getElementById('readOutput').innerText = JSON.stringify(res.data)
                ).catch(err => console.error(err));
        });
        // delete
        document.getElementById('deleteButton').addEventListener('click', function () {
            axios.delete(`${BASE_URL}/people/deletePeople/${document.getElemenetById('deleteInput').value}`)
                .then(res =>
                    displayOutput("deleteOutput", res)
                ).catch(err => console.error(err));
        });

    } 
})()     