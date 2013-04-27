<#import "/spring.ftl" as spring/>
<#import "../templates.ftl" as templates/>

<@templates.page "Add a new queue">
    <form action="" method="post">
        <fieldset>
            <legend>New queue</legend>
            <label>Name</label>
            <@spring.formInput "queue.name" "type='text' placeholder='Queue name'" />
            <button type="submit" class="btn">Submit</button>
        </fieldset>
    </form>
</@templates.page>