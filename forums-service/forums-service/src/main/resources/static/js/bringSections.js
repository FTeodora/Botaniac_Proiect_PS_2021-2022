var script = document.createElement('script');
script.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js';
document.getElementsByTagName('head')[0].appendChild(script);
window.onload= ev=>{
function createSectionDiv(forumSection){
    var anch=document.createElement('a');
    anch.setAttribute('href',"/forums/section?forumSection="+forumSection.name);
    var section = document.createElement('div');
    section.innerText=forumSection.displayName;

    anch.appendChild(section);
    anch.classList.add("section-anchor");
    document.getElementById('sections').appendChild(anch);

    section.classList.add("forum-sections-div");
    var brek = document.createElement('br');
    document.getElementById('sections').appendChild(brek);
}

    $.ajax({
        type: "GET",
        url: 'forums/forumsSections',
    success: function(json_string) {
    var list = JSON.parse(json_string);
       list.forEach((i)=>createSectionDiv(i));
    },
        error: function (e) {
            console.log(e);
        }
    });
};