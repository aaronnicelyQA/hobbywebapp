
var app = new function() {
  this.el = document.getElementById('tickets');

  this.tickets = [];

  
  
  this.FetchAll = function() {
    var data = '';

    if (this.tickets.length > 0) {
      for (i = 0; i < this.tickets.length; i++) {
        data += '<tr>';
        data += '<td>'+(i+1)+". " + this.tickets[i] + '</td>';
        data += '<td>'+(i+1)+". " + this.tickets[i] + '</td>';
        data += '<td>'+(i+1)+". " + this.tickets[i] + '</td>';
        data += '<td>'+(i+1)+". " + this.tickets[i] + '</td>';
        data += '<td><button onclick="app.Edit(' + i + ')"  class="btn btn-warning">Edit</button></td>';
        data += '<td><button onclick="app.Delete(' + i + ')"  class="btn btn-danger">Delete</button></td>';
        data += '</tr>';
      }
    }

    this.Count(this.tickets.length);
    return this.el.innerHTML = data;
  };

  this.Add = function () {
    el = document.getElementById('add-name','add-age','add-address','add-train');
    // Get the value
    var ticket = el.value;

    if (ticket) {
      // Add the new value
      this.tickets.push(ticket.trim());
      // Reset input value
      el.value = '';
      // Dislay the new list
      this.FetchAll();
    }
  };
  

  this.Edit = function (item) {
    var el = document.getElementById('edit-todo');
    // Display value in the field
    el.value = this.tickets[item];
    // Display fields
    document.getElementById('edit-box').style.display = 'block';
    self = this;

    document.getElementById('save-edit').onsubmit = function() {
      // Get value
      var ticket = el.value;

      if (ticket) {
        // Edit value
        self.tickets.splice(item, 1, ticket.trim());
        // Display the new list
        self.FetchAll();
        // Hide fields
        CloseInput();
      }
    }
  };

  this.Delete = function (item) {
    // Delete the current row
    this.tickets.splice(item, 1);
    // Display the new list
    this.FetchAll();
  };

  this.Count = function(data) {
    var el   = document.getElementById('counter');
    var name = 'Tickets';

    if (data) {
        if(data ==1){
            name = 'Ticket'
        }
      el.innerHTML = data + ' ' + name ;
    } 
    else {
      el.innerHTML = 'No ' + name;
    }
  };
  
}

app.FetchAll();

function CloseInput() {
  document.getElementById('edit-box').style.display = 'none';
}