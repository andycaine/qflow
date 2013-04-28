<#import "/spring.ftl" as spring/>
<#import "../../templates.ftl" as templates/>

<@templates.page "Add an item">
    <form action="" method="post">
        <fieldset>
            <legend>New item</legend>
            <label>Description</label>
            <@spring.formInput "item.description" "type='text' placeholder='Item description'" />
            <button type="submit" class="btn btn-primary">Save</button>
        </fieldset>
    </form>
</@templates.page>