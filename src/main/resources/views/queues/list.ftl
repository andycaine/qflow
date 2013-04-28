<#-- @ftlvariable name="queues" type="java.util.Collection<Queue>" -->
<#import "../templates.ftl" as templates/>

<@templates.page "Queues">
    <#if queues?has_content>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <#list queues as queue>
            <tr class="queue">
                <td class="name"><a href="/queues/${queue.id}/items">${queue.name}</a></td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#else >
        <p>You don't have any queues.</p>
    </#if>
    <a id="new-queue-btn" class="btn btn-primary" href="/queues/new"><i class="icon-plus"></i> New Queue</a>
</@templates.page>