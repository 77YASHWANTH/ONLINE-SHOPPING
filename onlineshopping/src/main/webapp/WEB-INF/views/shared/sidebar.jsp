 
 
 <p class="lead">Lets Deal</p>
                
        <div class="list-group">
           <c:forEach items="${categories}" var="category1" >
           
           		<a href="${contextRoot}/show/category/${category1.id}/products" class="list-group-item" id="a_${category1.name}">${category1.name}</a>
           </c:forEach>     
                
        </div>
           