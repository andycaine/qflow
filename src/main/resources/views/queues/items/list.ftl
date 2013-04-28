<#-- @ftlvariable name="queue" type="qflow.Queue" -->
<#import "../../templates.ftl" as templates/>
<@templates.page "${queue.name} items">
    <#if queue.items?has_content>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <#list queue.items as item>
            <tr class="item">
                <#--<td class="description"><a href="/queues/${queue.id}/items/${item.id}">${item.description}</a></td>-->
                    <td class="description">${item.description}</td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#else >
        <p>There are no items in this queue.</p>
    </#if>
    <a id="new-item-btn" class="btn btn-primary" href="/queues/${queue.id}/items/new"><i class="icon-plus"></i> New Item</a>
</@templates.page>