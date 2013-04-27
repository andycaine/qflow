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
                <td class="name">${queue.name}</td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#else >
        <p>You don't have any queues.  Create one <a href="/queues/new">here</a></p>
    </#if>
</@templates.page>