window.localStorage.setItem('lc',window.localStorage.getItem('lc')||0);
window.sessionStorage.setItem('sc',0);
function gen(){
    document.getElementById('lc').textContent=window.localStorage.getItem('lc');
    document.getElementById('sc').textContent=window.sessionStorage.getItem('sc');
}
function increment1(){
      window.localStorage.setItem('lc',parseInt(window.localStorage.getItem('lc'))+1);
      document.getElementById('lc').textContent=window.localStorage.getItem('lc');
}
function increment2(){
    window.sessionStorage.setItem('sc',parseInt(window.sessionStorage.getItem('sc'))+1);
    document.getElementById('sc').textContent=window.sessionStorage.getItem('sc');
}