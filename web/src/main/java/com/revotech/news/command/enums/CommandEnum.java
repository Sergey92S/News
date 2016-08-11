package com.revotech.news.command.enums;

import com.revotech.news.command.*;

/**
 * Created by Revotech on 14.06.2016.
 */
public enum CommandEnum {
    NEWSLIST {
        {
            this.command = new NewsListCommand();
        }
    },
    ADDNEWS {
        {
            this.command = new AddNewsCommand();
        }
    },
    SAVE {
        {
            this.command = new SaveCommand();
        }
    },
    UPDATE {
        {
            this.command = new UpdateCommand();
        }
    },
    CANCEL {
        {
            this.command = new CancelCommand();
        }
    },
    DELETE {
        {
            this.command = new DeleteCommand();
        }
    },
    DELETEHREF {
        {
            this.command = new DeleteHrefCommand();
        }
    },
    VIEW {
        {
            this.command = new ViewCommand();
        }
    },
    EDIT {
        {
            this.command = new EditCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
