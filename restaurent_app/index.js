let modal=document.getElementById("modal");
let l=document.getElementById("t3");
l.style.display="flex";
let closemodal= () => {
    modal.style.display="none";
    tableload();
}
let f= document.getElementById("fill_up");
let f1=f;
let dname;
let name;
let course;
let type;
let price;
let c=0;
function del(obj){
    for(let i in obj){
        delete obj[i];
    }
}
function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
        console.log("run")
    }
}
let items={
    hyderabadi_dum_biryani:{name:"biriyani",course:"main course",type:"non-veg",price:"350"},
    chocolate_milkshake:{name:"shakes",course:"drinks",type:"veg",price:"200"},
    chicken_momos:{name:"momos",course:"starters",type:"non-veg",price:"250"},
    veg_momos:{name:"momos",course:"starters",type:"veg",price:"150"},
    french_fries:{name:"fries",course:"starters",type:"veg",price:"200"},
    chicken_lollypop:{name:"lollypop",course:"starters",type:"non-veg",price:"250"},
    veg_manchurian:{name:"manchurian",course:"starters",type:"veg",price:"150"},
    mutton_dum_biryani:{name:"biriyani",course:"main course",type:"non-veg",price:"450"},
    panner_butter_masala:{name:"curry",course:"main course",type:"veg",price:"200"},
    mojito_mocktail:{name:"moktail",course:"drinks",type:"veg",price:"100"}
}
function add_item()
{
    dname=document.getElementById("Dname").value;
    document.getElementById("Dname").value=""
    dname=dname.split(" ").join("_");
    console.log(dname)
    name=document.getElementById("name").value;
    document.getElementById("name").value=""
    course=document.getElementById("course").value;
    document.getElementById("course").value=""
    type=document.querySelector('input[name="type"]:checked').value;
    document.querySelector('input[name="type"]:checked').value="unchecked"
    price=document.getElementById("price").value;
    document.getElementById("price").value=""
    let p={name:name,course:course,type:type,price:price}
    items[dname]=p;
    console.log(items[dname]);
    closemodal2();
    menuload();
    tableload();
}
function menuload(){
    let P=document.getElementsByClassName('bdy')[1];
    removeAllChildNodes(P);
    for(let i in items)
    {
        let p=document.createElement("div");
        p.setAttribute('class','cells');
        let c1=document.createElement("h3");
        c1.setAttribute('draggable','true');
        c1.setAttribute('ondragstart','start(event)')
        let c2=document.createElement("p");
        let t1=document.createTextNode(i.split("_").join(" "));
        let t2=document.createTextNode("price : "+items[i]['price'])
        c1.appendChild(t1);
        c2.appendChild(t2);
        p.appendChild(c1);
        p.appendChild(c2);
        console.log(p);
        P.appendChild(p);
        console.log(i);
    }
}
function filter_menu(){
    let sl={};
    let count=0;
    let s=document.getElementsByClassName("menu_srch")[0].value
    if(s=="all" || s.length==0)
    {
        document.getElementsByClassName('bdy')[1 ].style.display="flex";
        menuload();
        return;
    }
    else{
        for(let i in items){
            let p=i;
            if(i.split("_").join(" ")==s)
            {
                sl[i]=items[i];
                count++;
                
            }
            else if(items[p]["name"]==s){
                sl[i]=items[i];
                count++;
            }
            else if(items[p]["course"]==s){
                sl[i]=items[i];
                count++;
            }
            else if(items[p]["type"]==s){
                sl[i]=items[i];
                count++;
            }
        }
    }
    if(count==0){
        document.getElementsByClassName('bdy')[1].style.display="none";
    }
    else{
        let P=document.getElementsByClassName('bdy')[1];
        removeAllChildNodes(P);
        document.getElementsByClassName('bdy')[1].style.display="flex";
        for(let i in sl)
        {
            let p=document.createElement("div");
            p.setAttribute('class','cells');
            let c1=document.createElement("h3");
            c1.setAttribute('draggable','true');
            c1.setAttribute('ondragstart','start(event)')
            let c2=document.createElement("p");
            let t1=document.createTextNode(i.split("_").join(" "));
            let t2=document.createTextNode("price : "+items[i]['price'])
            c1.appendChild(t1);
            c2.appendChild(t2);
            p.appendChild(c1);
            p.appendChild(c2);
            console.log(p);
            P.appendChild(p);
            console.log(i);
        }
    }
}
function srchtble(){
let sd=document.getElementsByClassName("tble_srch")[0].value;
let tl=['t1','t2','t3','t4','t5','t6','t7','t8','t9']
if(sd=="all" || sd=="All" || sd.length==0){
for(let i =0;i<9;i++){
    document.getElementsByClassName('bdy')[0].style.display="flex";
    document.getElementById(tl[i]).style.display="flex";
}
}
else if (0<sd[sd.length-1] && 9>=sd[sd.length-1]){
     let p=parseInt(sd[sd.length-1]);
     document.getElementsByClassName('bdy')[0].style.display="flex";
     for(let i=0;i<9;i++){
        if(i==p-1){
            document.getElementById(tl[i]).style.display="flex";
        }
        else{
            document.getElementById(tl[i]).style.display="none";
        }
     }
}
else{
    document.getElementsByClassName('bdy')[0].style.display="none";
}
}
function total_items_bill(tables,id){
    let count=0,bill=0;
    for(let i in tables[id]['items'])
    {
        count+=tables[id]['items'][i];
        bill+=parseInt(items[i]["price"])*tables[id]['items'][i];
    }
    return {count,bill};
}
function start(event){
    event.dataTransfer.setData("Text", event.target.textContent);
}
function over(event){
    event.preventDefault();
}
function drop(event,obj)
{
    let fi=event.dataTransfer.getData('Text');
    fi=fi.split(" ").join('_');
    if(tables[obj.id]['items'][fi]==undefined){
        tables[obj.id]['items'][fi]=1;
    }
    else{
        tables[obj.id]['items'][fi]+=1;
    }
    let {count,bill}=total_items_bill(tables,obj.id)
    obj.querySelectorAll('p')[0].textContent="items : "+count;
    obj.querySelectorAll('p')[1].textContent="bill : "+bill;
    console.log(tables[obj.id]['items'][fi])
    console.log(tables[obj.id]);
}
function tableload(){
let tl=['t1','t2','t3','t4','t5','t6','t7','t8','t9']
for(let i =0;i<9;i++){
    let obj=document.getElementById(tl[i]);
    let {count,bill}=total_items_bill(tables,tl[i]);
    console.log(count+" "+bill)
    obj.getElementsByTagName('p')[0].textContent="items : "+count;
    obj.getElementsByTagName('p')[1].textContent="bill : "+bill;
    obj.style.backgroundColor="#888888b1";
}
console.log("its is a table load")
}

function gen(){
    menuload();
    tableload();
}
function openmodal(obj){
   // console.log("on-clik "+obj.style.backgroundColor)
    obj.style.backgroundColor="yellow"
    console.log("on-clik "+obj.style.backgroundColor)
    let tp=0;
    const cnt=obj.getElementsByTagName("h3")[0];
    const cnt2=obj.getElementsByTagName("p")[0];
    const ddata=document.getElementById("contents")
    removeAllChildNodes(ddata);
    document.getElementById("mdl-hdr").textContent=cnt.textContent;
    modal.style.display="flex";
    obj=obj.id
    if(cnt2.textContent[0]=='i'){
       console.log("yess")
       let R=document.createElement("div");
       R.setAttribute('id',"hollow_gram");
       for(let i in tables[obj]["items"])
       {
            console.log(i)
            let P=document.createElement("div");
            P.setAttribute('class',`${c}`)
            let t=document.createElement("p");
            let t2=document.createTextNode(`${i.split("_").join(" ")}`);
            t.appendChild(t2);
            P.appendChild(t);
            let p=document.createElement("input");
            p.setAttribute('type','number');
            p.setAttribute('min','1');
            p.setAttribute('max','7');
            p.setAttribute('name',`${obj}`)
            p.setAttribute("id",`${i}`);
            p.setAttribute("class",`${c}`);
            p.setAttribute('value',`${tables[obj]["items"][i]}`);
            p.style.padding="5px";
            p.style.margin="5px";
            P.appendChild(p);
            let p2=document.createElement("button");
            p2.setAttribute("onclick",`increment(this)`)
            let p3=document.createTextNode("➕");
            p2.appendChild(p3);
            p2.setAttribute("class",`${c}`)
            p2.style.padding="5px";
            p2.style.margin="5px";
            P.appendChild(p2)
            let p4=document.createElement("button");
            p4.setAttribute("onclick","deleting(this)")
            p4.setAttribute("name",`${obj}`)
            p4.setAttribute("id",`${i}`)
            p4.setAttribute("class",`${c}`)
            let p5=document.createTextNode("🗑");
            p4.appendChild(p5);
            p4.style.padding="5px";
            p4.style.margin="5px";
            P.appendChild(p4);
            R.appendChild(P);
            c+=1;
            tp++;
       }
       R.style.marginBlockEnd="2rem";
       obj=document.getElementById(obj);
       let pp=obj.getElementsByTagName('p')[0].textContent+" , "+obj.getElementsByTagName('p')[1].textContent;
       let h1=document.createElement('p');
       let h2=document.createTextNode(pp);
       h1.append(h2);
       h1.setAttribute('id','contrib')
       console.log(h1)
       document.getElementById("contents").append(h1)
       gr=document.createElement("button")
       gr.setAttribute('class',"gen_btn")
       gr.setAttribute("onclick",`gen_bill(${obj.id})`)
       gc=document.createTextNode("generate bill and close table")
       gr.appendChild(gc);
       R.style.margin="1rem";
       if(tp==0){
        gr.style.display="none";
       }
       else{
        gr.style.display="inline-block";
       }
       document.getElementById("contents").appendChild(R);
       document.getElementById("contents").appendChild(gr);
       console.log("exec")
       
    }
}
function increment(ob1){
    console.log(ob1);
    let t=ob1.parentNode;
    t=t.querySelector('input[type="number"]');
    console.log(t.value+" ----"+t.id+" "+t.name)
    tables[t.name]['items'][t.id]=parseInt(t.value);
    let q=ob1.parentNode.parentNode
    console.log(q.parentNode)
    tableload();
    let z=document.getElementById(t.name);
    openmodal(z);
}
function deleting(obj)
{
    console.log(obj.id," - ",obj.name);
    delete tables[obj.name]['items'][obj.id];
    tableload();
    m=obj.parentNode.parentNode.parentNode
    //let j=m.getElementById('contrib')
    let z=document.getElementById(obj.name);
    openmodal(z)
    obj.parentNode.remove();
    o=document.getElementById(obj.name);
}
function gen_bill(obj){
    let total=0;
    console.log(obj.id)
    let modal3=document.getElementById("modal3");
    let target=document.getElementsByClassName("modal-body3")[0];
    removeAllChildNodes(target);
    let t1=document.createTextNode("bill reciept")
    let t2=document.createElement('p')
    t2.appendChild(t1)
    let h=document.createElement('div');
    h.setAttribute('class','bill-header');
    h.appendChild(t2);
    target.appendChild(h);
    for(let i in tables[obj.id]['items'])
    {
            let name=i.split("_").join(" ");
            let times=tables[obj.id]['items'][i];
            let t=tables[obj.id]['items'][i] * items[i]['price']
            delete tables[obj.id]['items'][i];
            let ut=document.createTextNode(`${name} x ${times} ----------------------------------------------------------${t}`)
            let gt=document.createElement('p')
            gt.appendChild(ut);
            target.appendChild(gt);
            total+=t;
    }
    let ut=document.createTextNode(`total ----------------------------------------------------------${total}`)
    let gt=document.createElement('p')
    let bt=document.createElement("button")
    bt.setAttribute("onclick","closemodal3()")
    bt.setAttribute("class","db")
    let bd=document.createTextNode("close_bill")
    bt.appendChild(bd)
    gt.appendChild(ut);
    target.appendChild(gt);
    modal3.appendChild(bt);
    modal3.style.display="flex";
}
function closemodal3(){
    let modal3=document.getElementById("modal3");
    let target=document.getElementsByClassName("modal-body3")[0];
    let target2=document.getElementsByClassName("db")[0];
    modal3.style.display="none";
    generate_pdf();
    modal3.removeChild(target2);
    tableload();
    closemodal();
}
function generate_pdf()
{
    let target=document.getElementsByClassName("modal-body3")[0];
    html2pdf()
    .from(target)
    .save()
}
let tables={
    t1:{items:{}},
    t2:{items:{}},
    t3:{items:{}},
    t4:{items:{}},
    t5:{items:{}},
    t6:{items:{}},
    t7:{items:{}},
    t8:{items:{}},
    t9:{items:{}}
}
function new_item(){
    let p=document.getElementsByClassName("m2")[0];
    p.style.display="flex";
    let c=p.querySelector("#content");
    c.appendChild(f);
}
function closemodal2()
{
    document.getElementsByClassName("m2")[0].style.display="none";
}