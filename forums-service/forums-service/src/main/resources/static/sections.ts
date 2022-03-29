function createSectionDiv(forumSection,){
    var section = document.createElement('div');
    section.innerText="hewwo";
    document.getElementById('sections').appendChild(section);
    var brek = document.createElement('br');
    document.getElementById('sections').appendChild(brek);
}

window.onload= ev=>{
    $.ajax({
        type: "get",
        url: 'forumsSections',
        contentType: "application/json; ",
        dataType: "json", 
    success: function(list) {
       list.forEach((i)=>createSectionDiv(i));
    },
        error: function (e) {
            console.log(e);
        }
    });
};