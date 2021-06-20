from typing import Dict


def a():
    pass


def create_user_obj(user_info) -> Dict:
    """
    Create user object
    :param user_info: user data retrieved from database
    :return: user information object
    """
    user = {}

    user['user_id'] = user_info['user_id'] if 'user_id' in user_info else ''

    user['user_first_name'] = user_info['user_first_name'] \
        if 'user_first_name' in user_info else ''

    user['user_last_name'] = user_info['user_last_name'] \
        if 'user_last_name' in user_info else ''

    user['user_image_path'] = user_info['user_image_path'] \
        if 'user_image_path' in user_info else ''

    user['user_birth'] = user_info['user_birth'] \
        if 'user_birth' in user_info else ''

    user['user_email'] = user_info['user_email'] \
        if 'user_email' in user_info else ''

    user['user_phone'] = user_info['user_phone'] \
        if 'user_phone' in user_info else ''

    user['user_parent_first_name'] = user_info['user_parent_first_name'] \
        if 'user_parent_first_name' in user_info else ''

    user['user_parent_last_name'] = user_info['user_parent_last_name'] \
        if 'user_parent_last_name' in user_info else ''

    user['user_parent_email'] = user_info['user_parent_email'] \
        if 'user_parent_email' in user_info else ''

    user['user_parent_phone'] = user_info['user_parent_phone'] \
        if 'user_parent_phone' in user_info else ''

    user['user_type'] = user_info['user_type'] \
        if 'user_type' in user_info else ''

    user['created_date'] = user_info['created_date'] \
        if 'created_date' in user_info else ''

    user['updated_date'] = user_info['updated_date'] \
        if 'updated_date' in user_info else ''


if __name__ == '__main__':
    pass
